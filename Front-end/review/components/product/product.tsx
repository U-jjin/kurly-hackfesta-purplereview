import Image from "next/image";

type ProductDetailProps = {
  img: string;
  title: string;
  price: number;
  discountPrice: number;
};

const Product: React.FC<ProductDetailProps> = ({
  img,
  title,
  price,
  discountPrice,
}) => {
  return (
    <section className='w-full h-100'>
      <div className='w-full px-2 py-3'>
        <Image
          src={img}
          alt={title}
          width={120}
          height={120}
          layout='responsive'
        />
      </div>

      <div className='flex flex-col w-full px-2 mt-3'>
        <span className='text-sm text-lightGray'>샛별 배송</span>
        <h3 className='text-2xl font-bold mb-2 text-black line-clamp-2'>
          {title}
        </h3>
        <div>
          {discountPrice !== -1 && (
            <span className='mr-3 pr-2 border-r line-through'>
              {discountPrice.toLocaleString("ko-kr")}원
            </span>
          )}
          <span className='text-2xl font-bold text-black'>
            {price.toLocaleString("ko-kr")}원
          </span>
        </div>
      </div>
    </section>
  );
};

export default Product;
