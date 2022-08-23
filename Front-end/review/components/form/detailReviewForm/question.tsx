import { useEffect, useState } from "react";

type QuestionProps = {
  question: string;
  answers: string[];
  questionId: number;
  onSaveAnswerByQuestion: (questionId: number, value: string) => void;
};

const Question: React.FC<QuestionProps> = ({
  question,
  answers,
  questionId,
  onSaveAnswerByQuestion,
}) => {
  const [selectedValue, setSelectedValue] = useState("");

  const onChangeHandler = (e: React.ChangeEvent) => {
    if (!(e.target instanceof HTMLInputElement)) return;
    setSelectedValue(e.target.value);
  };

  useEffect(() => {
    if (!selectedValue) return;
    onSaveAnswerByQuestion(questionId, selectedValue);
  }, [selectedValue]);

  return (
    <>
      <p className='text-2xl font-semibold pt-3'>{question}</p>
      <div className='space-y-2 px-4 mt-3'>
        {answers.map((answer) => (
          <div key={answer} className='w-full'>
            <input
              type='radio'
              id={answer}
              className='form-radio mr-3 text-main focus:ring-0'
              onChange={onChangeHandler}
              value={answer}
              checked={selectedValue === answer}
            />
            <label htmlFor={answer}>{answer}</label>
          </div>
        ))}
      </div>
    </>
  );
};

export default Question;
