import Link from "next/link";
import { useRouter } from "next/router";
import Image from "next/image";

type ProductCardProps = {
  title: string;
  imgUrl: string;
  price: number;
  discountPrice: number;
  slug: string;
};

const ProductCard: React.FC<ProductCardProps> = ({
  imgUrl,
  title,
  price,
  discountPrice,
  slug,
}) => {
  const { pathname, push } = useRouter();

  return (
    <>
      <Link href={`/productDetail/${slug}`} passHref>
        <a>
          <li
            className={`w-full h-28 flex space-x-2 mt-3 mb-7 ${
              pathname === "/review" && "border-[#d1d5db] border"
            }`}
          >
            <div className='w-[25%] px-2 py-3'>
              <Image
                src={imgUrl}
                alt={title}
                width={8}
                height={10}
                layout='responsive'
                objectFit='cover'
              />
            </div>
            <div className='flex flex-col py-3 w-[75%]'>
              <h3 className='text-sm text-black min-h-[45%] line-clamp-2'>
                {title}
              </h3>
              <div>
                <span className='text-md font-bold text-black mr-2'>
                  {price.toLocaleString("ko-kr")}원
                </span>
                {discountPrice !== -1 && (
                  <span className='text-sm font-bold text-gray line-through'>
                    {discountPrice.toLocaleString("ko-kr")}원
                  </span>
                )}
                <span className='text-xs ml-2 border-l pl-2 text-gray-500'>
                  1개
                </span>
              </div>
              <div className='flex justify-between mt-1'>
                <span className='text-sm'>배송완료</span>
                {pathname === "/ordered" && (
                  <button
                    className='bg-main py-2 px-3 rounded-sm text-sm text-white'
                    onClick={() => push(`/review/${slug}`)}
                  >
                    후기쓰기
                  </button>
                )}
              </div>
            </div>
          </li>
        </a>
      </Link>
    </>
  );
};

export default ProductCard;
