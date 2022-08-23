export const initialReviewState: initialReviewStateTypes = {
  productRating: 5,
  deliveryRating: {
    isSatisfied: true,
    dissatisfiedText: "",
  },
};

export type initialReviewStateTypes = {
  productRating: number;
  deliveryRating: getDeliveryRatingCreatorProps;
};
const PRODUCT_RATING = "review/PRODUCT_RATING";
const DELIVERY_RATING = "review/DELIVERY_RATING";

export type getProductRatingCreatorProps = number;

export type getDeliveryRatingCreatorProps = {
  isSatisfied: boolean;
  dissatisfiedText: string;
};

const getProductRatingCreator = (
  productRating: getProductRatingCreatorProps,
) => {
  return {
    type: PRODUCT_RATING,
    payload: { productRating: productRating },
  };
};

const getDeliveryRatingCreator = (rating: getDeliveryRatingCreatorProps) => {
  return {
    type: DELIVERY_RATING,
    payload: { deliveryRating: rating },
  };
};

type reviewReducerAction = {
  type: string;
  payload: {
    productRating?: getProductRatingCreatorProps;
    deliveryRating?: getDeliveryRatingCreatorProps;
  };
};

export const reviewReducer = (
  state = initialReviewState,
  action: reviewReducerAction,
) => {
  const { type, payload } = action;
  switch (type) {
    case PRODUCT_RATING: {
      if (!payload.productRating) return state;
      return {
        ...state,
        productRating: payload.productRating,
      };
    }
    case DELIVERY_RATING: {
      if (!payload.deliveryRating) return state;
      return {
        ...state,
        deliveryRating: payload.deliveryRating,
      };
    }

    default: {
      return state;
    }
  }
};

export const reviewActions = {
  getProductRatingCreator,
  getDeliveryRatingCreator,
};
