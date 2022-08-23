type RatingValueProps = {
  onChangeHandler: (e: React.ChangeEvent) => void;
  num: number;
};

const RatingValue: React.FC<RatingValueProps> = ({ onChangeHandler, num }) => {
  return (
    <>
      <label htmlFor={`ratingValue-${num}`} />
      <input
        id={`ratingValue-${num}`}
        value={num}
        type='radio'
        name='rating-2'
        className='daisy-mask daisy-mask-star-2 bg-main'
        onChange={onChangeHandler}
      />
    </>
  );
};

export default RatingValue;
