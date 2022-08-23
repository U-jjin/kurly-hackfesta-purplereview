type TextFormProps = {
  onChangeHandler: (e: React.ChangeEvent) => void;
  place: string;
};

const TextForm: React.FC<TextFormProps> = ({ onChangeHandler, place }) => {
  const placeHolderText =
    place === "deliveryRating"
      ? "불편사항을 적어주시면, 빠르게 대처하겠습니다."
      : "필요하시면 텍스트 후기를 남겨주세요";
  return (
    <div className='flex items-center justify-center'>
      <label htmlFor='delivery-dissatisfaction-textReview' />
      <textarea
        id='delivery-dissatisfaction-textReview'
        className='w-[95%] h-40 border mt-5 border-gray-500 px-3 py-3 focus:outline-none'
        placeholder={placeHolderText}
        onChange={onChangeHandler}
      />
    </div>
  );
};

export default TextForm;
