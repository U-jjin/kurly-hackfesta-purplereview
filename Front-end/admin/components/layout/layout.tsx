import Select from "../UI/select";
import BigLogo from "./BigLogo";
import { FetchedProductData } from "../../types/types";

type LayoutProps = {
  children: React.ReactNode;
  data: FetchedProductData[];
};

const Layout: React.FC<LayoutProps> = ({ children, data }) => {
  return (
    <div className='min-h-screen w-[1140px] px-5 space-y-5 '>
      <header className='w-full h-28 flex items-center justify-between bg-main px-6 py-2'>
        <div className='flex items-center'>
          <BigLogo color='white' />
          <h1 className='text-4xl ml-10 font-bold text-white'>리뷰 관리</h1>
        </div>
        <Select data={data} />
      </header>
      <main className='w-full min-h-[80vh] flex'>{children}</main>
    </div>
  );
};

export default Layout;
