import React, { useEffect, useState } from "react";

import { ThumbUpIcon, ThumbDownIcon } from "@heroicons/react/outline";
import TextForm from "../textForm";

import { reviewState } from "../../../store/store";
import { useSetRecoilState } from "recoil";

const DeliveryRatingForm: React.FC = () => {
  const [isSatisfied, setIsSatisfied] = useState(true);
  const setDeliveryReview = useSetRecoilState(reviewState);

  const onChangeHandler = (e: React.ChangeEvent) => {
    if (!(e.target instanceof HTMLInputElement)) return;
    const selectedRating = e.target.value === "true" ? true : false;
    setIsSatisfied(selectedRating);

    if (selectedRating) {
      setDeliveryReview((prev) => {
        return {
          ...prev,
          deliverySatisfaction: selectedRating ? "Good" : "bad",
          deliveryContent: "",
        };
      });
    } else {
      setDeliveryReview((prev) => {
        return {
          ...prev,
          deliverySatisfaction: selectedRating ? "Good" : "bad",
        };
      });
    }
  };

  const textFormOnChangeHandler = (e: React.ChangeEvent) => {
    if (!(e.target instanceof HTMLTextAreaElement)) return;
    const deliveryReviewText = e.target.value.trim();
    setDeliveryReview((prev) => {
      return {
        ...prev,
        deliveryContent: deliveryReviewText,
      };
    });
  };

  return (
    <>
      <div className='text-3xl font-semibold text-black'>
        배송은 어떠셨어요?
      </div>
      <form className='flex flex-col'>
        <div className='flex mx-auto mt-5'>
          <label htmlFor='delivery-satisfaction'>
            <ThumbUpIcon
              className={`w-12 mr-12 ${
                isSatisfied && "fill-main"
              }  stroke-black`}
            />
          </label>
          <input
            type='radio'
            id='delivery-satisfaction'
            className='hidden'
            value='true'
            checked={isSatisfied}
            onChange={onChangeHandler}
          />
          <label htmlFor='delivery-dissatisfaction'>
            <ThumbDownIcon
              className={`w-12 ${!isSatisfied && "fill-main"} stroke-black`}
            />
          </label>
          <input
            type='radio'
            id='delivery-dissatisfaction'
            className='hidden'
            value='false'
            checked={!isSatisfied}
            onChange={onChangeHandler}
          />
        </div>

        {!isSatisfied && (
          <TextForm
            onChangeHandler={textFormOnChangeHandler}
            place='deliveryRating'
          />
        )}
      </form>
    </>
  );
};

export default DeliveryRatingForm;
