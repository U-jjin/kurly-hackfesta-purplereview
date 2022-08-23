import React, { useState } from "react";
import { useRouter } from "next/router";
import { useRecoilState } from "recoil";
import { reviewState } from "../../store/store";

import type { Params, FetchedProductData } from "../../types/types";
import type { GetStaticProps, InferGetStaticPropsType } from "next/types";

import Layout from "../../components/layout/layout";
import ProductRatingForm from "../../components/form/productRatingForm/index";
import DeliveryRatingForm from "../../components/form/deliveryRatingForm";
import DetailReviewForm from "../../components/form/detailReviewForm";
import ProductCard from "../../components/product/productCard";

import { fetcher } from "../../lib/lib";
import { DATA_END_POINT, END_POINT_QUERY } from "../../constants/constants";

const Review = ({
  reviewData,
}: InferGetStaticPropsType<typeof getStaticProps>) => {
  const router = useRouter();
  const [detailReviewIsSelected, setDetailReviewIsSelected] = useState(false);
  const [allReviewState, setAllReviewState] = useRecoilState(reviewState);

  const { imgURL, name, price, discountPrice, itemId, questionList } =
    reviewData;

  const reviewSubmitHandler = async () => {
    const response = await fetch(
      `http://ec2-13-124-42-109.ap-northeast-2.compute.amazonaws.com:80/review/${itemId}`,
      {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(allReviewState),
      },
    );

    router.push("/ordered");
  };

  const buttonOnClickHandler = () => {
    setDetailReviewIsSelected(!detailReviewIsSelected);
    setAllReviewState((prev) => {
      return {
        ...prev,
        keywordReviews: [],
        itemContent: "",
      };
    });
  };

  return (
    <Layout>
      <ProductCard
        title={name}
        imgUrl={imgURL}
        price={price}
        discountPrice={discountPrice}
        slug={itemId.toString()}
      />

      <div className='bg-[#f3f4f6] px-3 py-5 w-full flex flex-col'>
        <ProductRatingForm question='제품은 어떠셨어요 ?' />
        <DeliveryRatingForm />

        {detailReviewIsSelected && (
          <>
            <span className='w-[90%] h-1 border-b mt-8 mb-5 mx-auto border-b-gray' />
            <DetailReviewForm questions={questionList} />
          </>
        )}
      </div>

      <div className='flex flex-col items-center space-y-4 pt-5'>
        <button
          className='bg-main w-[60%] h-16 text-white rounded-lg'
          onClick={buttonOnClickHandler}
        >
          {detailReviewIsSelected
            ? "상세한 후기 작성 그만하기"
            : "상세한 후기 작성하기"}
        </button>
        <button
          className='bg-main w-[60%] h-16 text-white rounded-lg'
          onClick={reviewSubmitHandler}
        >
          {detailReviewIsSelected ? "그대로 제출하기" : "제출하기"}
        </button>
      </div>
    </Layout>
  );
};

export default Review;

export const getStaticPaths = async () => {
  const { itemlist } = await fetcher(
    DATA_END_POINT,
    END_POINT_QUERY.ORDER_LIST,
  );
  const paths = itemlist.map(({ itemId }: FetchedProductData) => {
    return {
      params: {
        slug: itemId.toString(),
      },
    };
  });

  return {
    paths,
    fallback: false,
  };
};

export const getStaticProps: GetStaticProps = async (context) => {
  const { slug } = context.params as Params;

  const { itemlist } = await fetcher(
    DATA_END_POINT,
    END_POINT_QUERY.ORDER_LIST,
  );
  const reviewData = itemlist.find(
    ({ itemId }: FetchedProductData) => itemId.toString() === slug,
  );

  return {
    props: {
      reviewData,
    },
  };
};
