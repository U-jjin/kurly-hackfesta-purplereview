import React from "react";

import { useSetRecoilState } from "recoil";
import { reviewState } from "../../../store/store";

import TextForm from "../textForm";
import Question from "./question";

type DetailReviewFormProps = {
  answerlist: string[];
  asking: string;
  questionId: number;
};

const DetailReviewForm = ({
  questions,
}: {
  questions: DetailReviewFormProps[];
}) => {
  const setDetailReview = useSetRecoilState(reviewState);

  const textFormOnChangeHandler = (e: React.ChangeEvent) => {
    if (!(e.target instanceof HTMLTextAreaElement)) return;
    const itemContent = e.target.value.trim();
    setDetailReview((prev) => {
      return {
        ...prev,
        itemContent,
      };
    });
  };

  const onSaveAnswerByQuestion = (questionId: number, value: string) => {
    setDetailReview((prev) => {
      const isAlreadySelected = prev.keywordReviews.findIndex(
        (keywordReview) => keywordReview.questionId === questionId,
      );

      let newState: {
        questionId: number | null;
        value: string | null;
      }[];

      if (isAlreadySelected !== -1) {
        newState = prev.keywordReviews.map((v, i) => {
          if (i === isAlreadySelected) {
            return {
              questionId,
              value,
            };
          } else return v;
        });
      } else {
        newState = [
          ...prev.keywordReviews,
          {
            questionId,
            value,
          },
        ];
      }

      return {
        ...prev,
        keywordReviews: newState,
      };
    });
  };

  return (
    <>
      <form className='space-y-3 w-full text-black'>
        {questions.map((question) => (
          <React.Fragment key={question.questionId}>
            <Question
              question={question.asking}
              answers={question.answerlist}
              questionId={question.questionId}
              onSaveAnswerByQuestion={onSaveAnswerByQuestion}
            />
            <div className='w-[90%] h-5 border-b mt-5 mb-5 mx-auto border-b-gray' />
          </React.Fragment>
        ))}
      </form>
      <TextForm
        onChangeHandler={textFormOnChangeHandler}
        place='detailReview'
      />
    </>
  );
};

export default DetailReviewForm;
