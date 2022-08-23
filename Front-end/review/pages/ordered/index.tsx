import React from "react";
import type { GetStaticProps, InferGetStaticPropsType } from "next/types";
import type { FetchedProductData } from "../../types/types";

import Layout from "../../components/layout/layout";
import ProductCard from "../../components/product/productCard";
import Divider from "../../components/UI/divider";

import { fetcher } from "../../lib/lib";
import { DATA_END_POINT, END_POINT_QUERY } from "../../constants/constants";

const OrderedProducts = ({
  productData,
}: InferGetStaticPropsType<typeof getStaticProps>) => {
  return (
    <Layout>
      <ul className='w-full h-full flex flex-col'>
        {productData.map((singleProduct: FetchedProductData) => (
          <React.Fragment key={singleProduct.name}>
            <Divider />
            <ProductCard
              title={singleProduct.name}
              imgUrl={singleProduct.imgURL}
              price={singleProduct.price}
              discountPrice={singleProduct.discountPrice}
              slug={singleProduct.itemId.toString()}
            />
          </React.Fragment>
        ))}
      </ul>
    </Layout>
  );
};

export default OrderedProducts;

export const getStaticProps: GetStaticProps = async () => {
  const { itemlist } = await fetcher(
    DATA_END_POINT,
    END_POINT_QUERY.ORDER_LIST,
  );
  return {
    props: {
      productData: itemlist,
    },
  };
};
