export const fetcher = async (url: string, query: string, slug?: string) => {
  const URL = `${url}${query}${slug ? slug : ""}`;
  const response = await fetch(URL);
  const data = await response.json();

  return data;
};
