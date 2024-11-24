import React from "react";
import ProductCard from "./ProductCard";
import { Grid } from "@mui/material";

function ProductList({ products }) {
  return (
    <Grid container spacing={2} justifyContent="center">
      {products.map((product) => (
        <ProductCard key={product.id} product={product} />
      ))}
    </Grid>
  );
}

export default ProductList;
