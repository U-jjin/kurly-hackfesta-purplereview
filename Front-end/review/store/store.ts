import { atom } from "recoil";

export const reviewState = atom<reviewAtomTypes>({
  key: "ReviewState",
  default: {
    memberId: 1,
    itemContent: "",
    deliveryContent: "",
    star: 5,
    deliverySatisfaction: "Good",
    keywordReviews: [],
  },
});

type reviewAtomTypes = {
  memberId: number;
  itemContent: string;
  deliveryContent: string;
  star: number;
  deliverySatisfaction: string;
  keywordReviews: {
    questionId: null | number;
    value: null | string;
  }[];
};
