type ReviewProgressBarProps = {
  description: string;
  ratio: string;
  isMax: boolean;
};

const ReviewProgressBar: React.FC<ReviewProgressBarProps> = ({
  description,
  ratio,
  isMax,
}) => {
  return (
    <div className='flex w-full items-center justify-between mt-1'>
      <span
        className={`text-sm mr-1 w-32 font-semibold ${
          isMax ? "text-main" : "text-black"
        }`}
      >
        {description}
      </span>
      <div className='flex items-center w-48 mr-5'>
        <progress
          className={`daisy-progress w-full ${
            isMax ? "daisy-progress-primary" : "daisy-progress-black"
          }`}
          value={ratio}
          max='100'
        />
      </div>
      <span
        className={`text-sm font-semibold ${
          isMax ? "text-main font-bold" : "text-black"
        }`}
      >
        {ratio}%
      </span>
    </div>
  );
};

export default ReviewProgressBar;
