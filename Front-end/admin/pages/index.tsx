import Link from "next/link";

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
      <div className='min-h-[80vh] flex flex-col'>
        <div className='h-full mx-auto'>
          <BigLogo color='white' width='280px' height='240px' />
          <h1 className='text-4xl text-white text-center'>리뷰 관리하기</h1>
        </div>

        <div className='mt-20'>
          <ul className='flex flex-col items-center space-y-1'>
            {allProductsById.map(({ itemId, name }: AllProductById) => (
              <Link href={`/reviewByProduct/${itemId}`} passHref>
                <a>
                  <li className='text-lg hover:underline text-white'>{name}</li>
                </a>
              </Link>
            ))}
          </ul>
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
