import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Products } from "../model/products";
import { ProductDetails } from "../model/product-details";
import { ProductForm } from "../model/product-form";

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getProducts(): Observable<Products> {
    return this.http.get<Products>('/api/products');
  }

  getProduct(uuid: string): Observable<ProductDetails> {
    return this.http.get<ProductDetails>('/api/products/' + uuid);
  }

  deleteProduct(uuid: string): Observable<any> {
    return this.http.delete('/api/products/' + uuid);
  }

  createProduct(productForm: ProductForm): Observable<any> {
    return this.http.post('/api/products', productForm);
  }

  updateProduct(uuid: string, productForm: ProductForm): Observable<any> {
    return this.http.put('/api/products/' + uuid, productForm);
  }
}
