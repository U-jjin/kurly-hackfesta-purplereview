import type { NextPage } from "next";
import Link from "next/link";
import BigLogo from "../components/layout/bigLogo";
import Layout from "../components/layout/layout";

const Home: NextPage = () => {
  return (
    <Layout>
      <div className='h-full flex flex-col items-center justify-center'>
        <div className='flex flex-col items-center '>
          <BigLogo color='white' />
          <span className='text-md max-w-full text-center text-white mt-3'>
            컬리만을 위한, 키워드 리뷰 시스템
          </span>
          <h1 className='text-2xl text-white font-bold'>
            PurPle Review 퍼플리뷰
          </h1>
        </div>

        <div className='w-full text-center mt-5 space-y-5'>
          <Link href={"/ordered"}>
            <a className='w-[70%] bg-[#d1d5db] text-main font-bold py-5 text-2xl inline-block rounded-lg hover:bg-white'>
              리뷰 시작하기
            </a>
          </Link>

          <a
            target='_black'
            href='http://kurlyreviewadmin.com/'
            className='w-[70%] bg-[#d1d5db] text-main py-5 font-bold text-2xl inline-block rounded-lg hover:bg-white'
          >
            관리자 페이지 둘러보기
          </a>
        </div>

        <div className='w-full text-center mt-5'>
          <span className='inline-block text-md text-lightGray font-semibold mt-5'>
            컬리가 컬컬컬
          </span>
          <div className='w-full space-x-3 text-lightGray text-sm text-gray-600'>
            <span>안유진</span>
            <span>송재현</span>
            <span>손정호</span>
          </div>
        </div>
      </div>
    </Layout>
  );
};

export default Home;
