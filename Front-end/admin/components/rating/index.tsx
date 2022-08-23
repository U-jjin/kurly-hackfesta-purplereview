type RatingProps = {
  title: string;
  rating: string;
};

const Rating: React.FC<RatingProps> = ({ title, rating }) => {
  return (
    <div className='flex flex-col'>
      <span className='text-md text-center mb-3'>{title}</span>
      <span className='text-5xl h-20 w-44 text-white bg-main flex items-center justify-center rounded-lg'>
        {rating}
      </span>
    </div>
  );
};

export default Rating;
