import { Component, OnInit } from '@angular/core';
import { ProductService } from "../../service/product.service";
import { WarehouseService } from "../../../warehouse/service/warehouse.service";
import { ActivatedRoute, Router } from "@angular/router";
import { ProductForm } from "../../model/product-form";
import { Warehouses } from "../../../warehouse/model/warehouses";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {

  constructor(private service: ProductService,
              private warehouseService: WarehouseService,
              private route: ActivatedRoute,
              private router: Router
  ) {}

  uuid: string | undefined;

  product: ProductForm | undefined;

  original: ProductForm | undefined;

  warehouses: Warehouses | undefined;

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.service.getProduct(params['id']).subscribe((product => {
        this.uuid = params['id'];
        this.product = {
          name: product.name,
          weight: product.weight,
          warehouseId: product.warehouseId
        };
        this.original = {...this.product};
      }));

      this.warehouseService.getWarehouses().subscribe((warehouses => {
        this.warehouses = warehouses;
      }));
    });
  }

  onSubmit(): void {
    this.service.updateProduct(this.uuid!, this.product!).subscribe(() =>
      this.router.navigate(['/warehouses', this.product!.warehouseId]));
  }

}
