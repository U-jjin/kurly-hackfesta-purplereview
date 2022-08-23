import RatingValue from "./ratingValue";

import { reviewState } from "../../../store/store";
import { useSetRecoilState } from "recoil";

type RatingProps = {
  question: string;
};

const productRatingConstants: number[] = [1, 2, 3, 4, 5];

const ProductRatingForm: React.FC<RatingProps> = ({ question }) => {
  const setProductReview = useSetRecoilState(reviewState);

  const ratingOnChangeHandler = (e: React.ChangeEvent) => {
    if (!(e.target instanceof HTMLInputElement)) return;
    const star = Number(e.target.value);
    setProductReview((prev) => {
      return {
        ...prev,
        star,
      };
    });
  };

  return (
    <>
      <div className='text-3xl font-semibold text-black'>{question}</div>
      <form className='daisy-rating mt-5 w-full flex justify-center daisy-rating-lg pb-10'>
        {productRatingConstants.map((value) => (
          <RatingValue
            key={value}
            onChangeHandler={ratingOnChangeHandler}
            num={value}
          />
        ))}
      </form>
    </>
  );
};

export default ProductRatingForm;
