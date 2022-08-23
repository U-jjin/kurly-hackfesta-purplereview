/** @type {import('next').NextConfig} */

const nextConfig = {
  reactStrictMode: false,
  swcMinify: true,
  images: {
    loader: "akamai",
    path: "",
    domains: ["img-cf.kurly.com"],
  },
};

module.exports = nextConfig;
