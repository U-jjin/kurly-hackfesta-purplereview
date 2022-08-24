import type { GetStaticProps, InferGetStaticPropsType } from "next/types";
import type { Params, FetchedProductData } from "../../types/types";

import LineChart from "../../components/chart/LineChart";
import Layout from "../../components/layout/layout";
import Rating from "../../components/rating";
import ReviewByQuestion from "../../components/reviewByQuestion";

import { DATA_END_POINT, END_POINT_QUERY } from "../../constants/constants";
import { fetcher } from "../../lib/lib";

type ReviewDataProps = {
  asking: string;
  category: string;
  answerlist: string[];
  ratiolist: string[];
};

const ReviewByProduct = ({
  allProductsById,
  reviewData,
  graphDataObj,
}: InferGetStaticPropsType<typeof getStaticProps>) => {
  const { deliveryScoreAvg, itemScoreAvg, graphData } = graphDataObj;

  return (
    <Layout data={allProductsById}>
      <div className='w-[50%] min-h-full border-r border-r-gray'>
        <div className='h-[20%] px-5 flex items-center justify-around'>
          <Rating title='제품만족도' rating={itemScoreAvg} />
          <Rating title='배송만족도' rating={`${deliveryScoreAvg}%`} />
        </div>
        {/* 왼쪽하단 */}
        <div className='border-t border-t-gray mt-14 w-[95%] mx-auto'></div>
        <div className='h-[60%] pt-8'>
          <span className='px-8 text-2xl font-semibold'>월별 만족도 현황</span>
          <LineChart data={graphData} />
        </div>
      </div>
      <div className='w-[50%] min-h-full px-3'>
        {reviewData.map((v: ReviewDataProps, i: number) => {
          return <ReviewByQuestion data={v} title={`depth - ${i + 2}`} />;
        })}
      </div>
    </Layout>
  );
};

export default ReviewByProduct;

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

  const allProductsById = itemlist.map(
    ({ itemId, name }: FetchedProductData) => {
      return {
        itemId: itemId,
        name,
      };
    },
  );

  const graphDataObj = await fetcher(
    DATA_END_POINT,
    END_POINT_QUERY.GRAPH_DATA,
    slugStr,
  );

  return {
    props: {
      allProductsById,
      reviewData,
      graphDataObj,
    },
  };
};

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
