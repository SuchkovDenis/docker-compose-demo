import React, { useEffect, useState } from "react";
import ProductList from "../components/ProductList";
import { TextField, Container } from "@mui/material";

function Home() {
  const [products, setProducts] = useState([]);
  const [searchTerm, setSearchTerm] = useState("");

  useEffect(() => {
    // Если строка поиска пустая, загружаем все продукты
    if (!searchTerm) {
      fetch("/api/products/")
        .then((response) => response.json())
        .then((data) => setProducts(data))
        .catch((error) => console.error("Error fetching products:", error));
    } else {
      // Иначе ищем продукты по поисковому запросу
      fetch(`/api/products/search?query=${searchTerm}`)
        .then((response) => response.json())
        .then((data) => setProducts(data))
        .catch((error) => console.error("Error searching products:", error));
    }
  }, [searchTerm]);

  const handleSearchChange = (event) => {
    setSearchTerm(event.target.value);
  };

  return (
    <Container>
      <TextField
        label="Search products"
        variant="outlined"
        fullWidth
        margin="normal"
        onChange={handleSearchChange}
      />
      <ProductList products={products} />
    </Container>
  );
}

export default Home;
