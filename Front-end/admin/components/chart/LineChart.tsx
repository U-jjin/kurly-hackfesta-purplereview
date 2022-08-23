import { ResponsiveLine } from "@nivo/line";
import React from "react";

type LineChartProps = {
  data: {
    delivery: string[];
    item: string[];
  };
};

const LineChart: React.FC<LineChartProps> = ({ data }) => {
  const { delivery, item } = data;

  const parsedProductData = item.map((v: string, i: number) => {
    const month = `${i + 9 > 12 ? i - 3 : i + 9}월`;
    return {
      x: month,
      y: (Number(v) * 20).toString(),
    };
  });

  const parsedDeliveryData = delivery.map((v: string, i: number) => {
    const month = `${i + 9 > 12 ? i - 3 : i + 9}월`;
    return {
      x: month,
      y: v,
    };
  });

  const chartData = [
    {
      id: "제품만족도",
      color: "red",
      data: parsedProductData,
    },
    {
      id: "배송만족도",
      color: "blue",
      data: parsedDeliveryData,
    },
  ];
  return (
    <ResponsiveLine
      data={chartData}
      xScale={{ type: "point" }}
      yScale={{
        type: "linear",
        min: 0,
        max: 100,
        stacked: false,
        reverse: false,
      }}
      margin={{ top: 50, right: 110, bottom: 50, left: 60 }}
      yFormat=' >-.2f'
      axisBottom={{
        tickSize: 5,
        tickPadding: 5,
        tickRotation: 0,
        legend: "월",
        legendOffset: 36,
        legendPosition: "middle",
      }}
      axisLeft={{
        tickSize: 5,
        tickPadding: 5,
        tickRotation: 0,
        legend: "만족도",
        legendOffset: -40,
        legendPosition: "middle",
      }}
      pointSize={10}
      pointColor={{ theme: "background" }}
      pointBorderWidth={2}
      pointBorderColor={{ from: "serieColor" }}
      pointLabel={function (t) {
        return t.x + ": " + t.y;
      }}
      pointLabelYOffset={-12}
      useMesh={true}
      legends={[
        {
          anchor: "bottom-right",
          direction: "column",
          justify: false,
          translateX: 100,
          translateY: 0,
          itemsSpacing: 0,
          itemDirection: "left-to-right",
          itemWidth: 80,
          itemHeight: 20,
          itemOpacity: 0.75,
          symbolSize: 12,
          symbolShape: "circle",
          symbolBorderColor: "rgba(0, 0, 0, .5)",
          effects: [
            {
              on: "hover",
              style: {
                itemBackground: "rgba(0, 0, 0, .03)",
                itemOpacity: 1,
              },
            },
          ],
        },
      ]}
    />
  );
};

export default LineChart;
