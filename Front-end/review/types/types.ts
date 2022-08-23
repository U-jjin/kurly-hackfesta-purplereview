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
    questionId: number;
    asking: string;
    answerlist: string[];
  }[];
};
