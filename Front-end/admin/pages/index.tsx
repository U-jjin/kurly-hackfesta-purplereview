import Link from "next/link";
import Head from "next/head";

import type { NextPage } from "next";
import type { GetStaticProps, InferGetStaticPropsType } from "next";
import type { AllProductById } from "../types/types";

import BigLogo from "../components/layout/BigLogo";

import { DATA_END_POINT, END_POINT_QUERY } from "../constants/constants";
import { fetcher } from "../lib/lib";

const Home: NextPage = ({
  allProductsById,
}: InferGetStaticPropsType<typeof getStaticProps>) => {
  return (
    <div className='min-h-screen w-[1140px] bg-main py-3 px-5 flex flex-col items-center justify-center'>
      <div className='min-h-[60vh] flex flex-col items-center'>
        <div className='h-full flex flex-col items-center'>
          <BigLogo color='white' width='280px' height='240px' />
          <div className='flex flex-col items-center'>
            <h1 className='text-4xl text-white text-center font-bold'>
              PurPle Review 퍼플리뷰
            </h1>
            <span className='text-2xl text-white mt-1'>리뷰 관리하기</span>
          </div>
        </div>

        <div className='mt-24'>
          <ul className='flex flex-col items-center space-y-1'>
            {allProductsById.map(({ itemId, name }: AllProductById) => (
              <Link href={`/reviewByProduct/${itemId}`} passHref key={itemId}>
                <a>
                  <li className='text-lg hover:underline text-white'>{name}</li>
                </a>
              </Link>
            ))}
          </ul>
        </div>

        <div className='mt-5 text-gray text-sm text-center'>
          <span>컬리가 컬컬컬</span>
          <div className='flex items-center justify-between w-36'>
            <span>안유진</span>
            <span>송재현</span>
            <span>손정호</span>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;

export const getStaticProps: GetStaticProps = async () => {
  const { itemlist } = await fetcher(
    DATA_END_POINT,
    END_POINT_QUERY.ORDER_LIST,
  );

  const allProductsById = itemlist.map((v: any) => {
    return {
      itemId: v.itemId,
      name: v.name,
    };
  });
  return {
    props: {
      allProductsById,
    },
  };
};
