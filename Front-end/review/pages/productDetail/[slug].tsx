import React from "react";
import type { GetStaticProps, InferGetStaticPropsType } from "next/types";
import type { Params, FetchedProductData } from "../../types/types";

import Layout from "../../components/layout/layout";
import Product from "../../components/product/product";
import ProductReview from "../../components/product/productReviews";

import { fetcher } from "../../lib/lib";
import { DATA_END_POINT, END_POINT_QUERY } from "../../constants/constants";

type ReviewDataProps = {
  asking: string;
  answerlist: string[];
  ratiolist: string[];
};

const ProductDetail = ({
  productData,
  reviewData,
}: InferGetStaticPropsType<typeof getStaticProps>) => {
  const { imgURL, name, price, discountPrice } = productData;

  return (
    <Layout>
      <Product
        img={imgURL}
        title={name}
        price={price}
        discountPrice={discountPrice}
      />
      {reviewData.map((data: ReviewDataProps) => (
        <React.Fragment key={data.asking}>
          <span className='w-[90%] h-1 border-b mt-0 mx-auto border-b-lightGray' />
          <ProductReview
            question={data.asking}
            answerlist={data.answerlist}
            answerRatio={data.ratiolist}
          />
        </React.Fragment>
      ))}
    </Layout>
  );
};

export default ProductDetail;

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
  const slugStr = slug?.toString();

  const reviewData = await fetcher(
    DATA_END_POINT,
    END_POINT_QUERY.ITEM,
    slugStr,
  );
  const { itemlist } = await fetcher(
    DATA_END_POINT,
    END_POINT_QUERY.ORDER_LIST,
  );

  const productData = itemlist.find(
    (data: FetchedProductData) => data.itemId.toString() === slug,
  );

  return {
    props: {
      reviewData,
      productData,
    },
  };
};
