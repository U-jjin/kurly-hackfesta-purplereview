import BarChart from "../chart/barChart";
import PieChart from "../chart/pieChart";

type ReviewByQuestionProps = {
  data: {
    asking: string;
    category: string;
    answerlist: string[];
    ratiolist: string[];
  };
  title: string;
};

const ReviewByQuestion: React.FC<ReviewByQuestionProps> = ({ data, title }) => {
  const { answerlist, asking, category, ratiolist } = data;

  return (
    <div className='h-[50%] border-b border-b-gray last:border-none'>
      <div className='px-5 h-[20%] bg-[#fff] flex items-center justify-between'>
        <span className='mr-5'>
          {title} {category}
        </span>

        <select
          className='w-80 form-select py-2 px-3 border-transparent focus:border-l-transparent focus:border-r-transparent  
    focus:border-t-transparent focus:ring-0 border-b-gray'
        >
          <option disabled selected>
            선택해주세요
          </option>
          <option selected>{asking}</option>
        </select>
      </div>
      <div className='h-[80%]'>
        {title === "depth - 2" ? (
          <BarChart
            chartData={ratiolist}
            asking={asking}
            answerlist={answerlist}
          />
        ) : (
          <PieChart
            chartData={ratiolist}
            asking={asking}
            answerlist={answerlist}
          />
        )}
      </div>
    </div>
  );
};

export default ReviewByQuestion;
