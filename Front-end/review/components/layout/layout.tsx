import Link from "next/link";
import { useRouter } from "next/router";
import React from "react";

import { ChevronLeftIcon } from "@heroicons/react/outline";
import Logo from "./logo";

const Layout = ({ children }: { children: React.ReactNode }) => {
  const router = useRouter();
  const { pathname, back } = router;

  return (
    <div
      className={`h-screen flex flex-col w-full overflow-y-scroll sm:w-[390px] sm:h-[720px] sm:border-gray sm:border sm:rounded-md ' ${
        pathname == "/" && "bg-main"
      }`}
    >
      {pathname !== "/" && (
        <>
          <header className='w-full flex items-center justify-between border-b px-3 py-2 bg-main'>
            <Link href='/' passHref>
              <a>
                <Logo />
              </a>
            </Link>
            <nav className='space-x-5'>
              <a className='text-md font-bold text-white'>관리자</a>
              <Link href='/ordered' passHref>
                <a className='text-md font-bold text-white'>주문완료</a>
              </Link>
            </nav>
          </header>
          <div className='flex items-center mt-2 px-3'>
            <ChevronLeftIcon
              className='w-5 text-start'
              onClick={() => back()}
            />
            <h2 className='text-lg font-semibold w-full text-center text-black'>
              {pathname === "/ordered"
                ? "주문 내역 상세"
                : pathname === "/review"
                ? "후기 작성하기"
                : "물품 상세 정보"}
            </h2>
          </div>
        </>
      )}
      <main className='h-full w-full flex flex-col space-y-5 mt-3 px-3 py-1'>
        {children}
      </main>
    </div>
  );
};

export default Layout;
