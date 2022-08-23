import { ParsedUrlQuery } from "querystring";

export type Params = {
  slug: string | string[] | ParsedUrlQuery | undefined;
};

export type FetchedProductData = {
  itemId: number;
  name: string;
  price: number;
  discountPrice: number;
  imgURL: string;
  categories: string[];
  questionList: {
    answerlist: string[];
    asking: string;
    questionId: number;
  }[];
};

export type AllProductById = {
  itemId: number;
  name: string;
};

export type ChartProps = {
  chartData: string[];
  asking: string;
  answerlist: string[];
};
