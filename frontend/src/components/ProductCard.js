import React from "react";
import { Card, CardMedia, CardContent, Typography, CardActionArea } from "@mui/material";
import { Link } from "react-router-dom";

function ProductCard({ product }) {
  return (
    <Card sx={{ width: 300, margin: "1rem" }}>
      <CardActionArea component={Link} to={`/product/${product.id}`}>
        <CardMedia component="img" height="140" image={product.image} alt={product.name} />
        <CardContent>
          <Typography gutterBottom variant="h5">
            {product.name}
          </Typography>
          <Typography variant="h6">{product.price}</Typography>
        </CardContent>
      </CardActionArea>
    </Card>
  );
}

export default ProductCard;
