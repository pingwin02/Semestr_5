import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { WarehouseService } from "../../service/warehouse.service";
import { WarehouseDetails } from "../../model/warehouse-details";
import { Products } from "../../../product/model/products";
import { ProductService } from "../../../product/service/product.service";
import { Product } from "../../../product/model/product";

@Component({
  selector: 'app-warehouse-view',
  templateUrl: './warehouse-view.component.html',
  styleUrls: ['./warehouse-view.component.css']
})
export class WarehouseViewComponent implements OnInit {

  constructor(private service: WarehouseService,
              private productService: ProductService,
              private route: ActivatedRoute,
  ) {
  }

  warehouse: WarehouseDetails | undefined;

  products: Products | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.service.getWarehouse(params['uuid']).subscribe((warehouse) => {
        this.warehouse = warehouse;
      });

      this.service.getWarehouseProducts(params['uuid']).subscribe((products) => {
        this.products = products;
      });

    });
  }

  onProductDelete(product: Product): void {
    this.productService.deleteProduct(product.id).subscribe(() => {
      this.ngOnInit();
    });
  }
}
