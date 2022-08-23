import { ResponsiveBar } from "@nivo/bar";
import type { ChartProps } from "../../types/types";

const BarChart: React.FC<ChartProps> = ({
  chartData,
  asking,
  answerlist,
}: ChartProps) => {
  const parsedData: { [key: string]: string } = { 질문명: asking };
  answerlist.forEach((v, i) => {
    parsedData[`${v}`] = chartData[i];
  });

  return (
    <ResponsiveBar
      data={[parsedData]}
      keys={answerlist}
      indexBy='질문명'
      margin={{ top: 0, right: 130, bottom: 60, left: 60 }}
      padding={0.3}
      layout='horizontal'
      valueScale={{ type: "linear" }}
      indexScale={{ type: "band", round: true }}
      colors={{ scheme: "nivo" }}
      defs={[
        {
          id: "lines",
          type: "patternLines",
          background: "inherit",
          color: "#eed312",
          rotation: -45,
          lineWidth: 6,
          spacing: 10,
        },
      ]}
      borderColor={{
        from: "color",
        modifiers: [["darker", 1.6]],
      }}
      axisTop={null}
      axisRight={null}
      axisBottom={{
        tickSize: 5,
        tickPadding: 5,
        tickRotation: 0,
        legend: asking,
        legendPosition: "middle",
        legendOffset: 32,
      }}
      axisLeft={{
        tickSize: 0,
        tickPadding: -5,
        tickRotation: 180,
        legendPosition: "middle",
        legendOffset: -40,
      }}
      labelSkipWidth={12}
      labelSkipHeight={12}
      labelTextColor={{
        from: "color",
        modifiers: [["darker", 1.6]],
      }}
      legends={[
        {
          dataFrom: "keys",
          anchor: "bottom-right",
          direction: "column",
          justify: false,
          translateX: 120,
          translateY: 0,
          itemsSpacing: 2,
          itemWidth: 100,
          itemHeight: 20,
          itemDirection: "left-to-right",
          itemOpacity: 0.85,
          symbolSize: 20,
          effects: [
            {
              on: "hover",
              style: {
                itemOpacity: 1,
              },
            },
          ],
        },
      ]}
      role='application'
      ariaLabel='Depth2-Question'
    />
  );
};

export default BarChart;
