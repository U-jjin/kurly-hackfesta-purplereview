import { useRouter } from "next/router";
import type { AllProductById } from "../../types/types";

type SelectProps = {
  data: AllProductById[];
};

const Select: React.FC<SelectProps> = ({ data }) => {
  const router = useRouter();
  const onChangeHandler = (e: React.ChangeEvent) => {
    if (!(e.target instanceof HTMLSelectElement)) return;
    router.push(`/reviewByProduct/${e.target.value}`);
  };

  return (
    <select
      className='w-80 form-select py-2 px-3 border-transparent focus:border-l-transparent focus:border-r-transparent  
    focus:border-t-transparent focus:ring-0 border-b-gray'
      onChange={onChangeHandler}
    >
      <option disabled>선택해주세요</option>
      {data.map((v) => (
        <option
          key={v.itemId}
          value={v.itemId}
          selected={v.itemId.toString() === router.query.slug}
        >
          {v.name}
        </option>
      ))}
    </select>
  );
};

export default Select;
