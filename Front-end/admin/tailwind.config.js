module.exports = {
  content: [
    "./pages/**/*.{js,ts,jsx,tsx}",
    "./components/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    colors: {
      main: "#5f0580",
      white: "#fff",
      gray: "#d1d5db",
      lightGray: "#e5e7eb",
      black: "#000",
      transparent: "transparent",
    },
    extend: {},
  },
  plugins: [require("@tailwindcss/forms")],
};
