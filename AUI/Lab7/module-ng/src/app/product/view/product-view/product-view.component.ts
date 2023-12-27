import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from "@angular/router";
import { ProductService } from "../../service/product.service";
import { ProductDetails } from "../../model/product-details";

@Component({
  selector: 'app-product-view',
  templateUrl: './product-view.component.html',
  styleUrls: ['./product-view.component.css']
})
export class ProductViewComponent implements OnInit {

  constructor(private service: ProductService,
              private route: ActivatedRoute,
  ) {
  }

  product: ProductDetails | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.service.getProduct(params['id']).subscribe((product) => {
        this.product = product;
      });
    });
  }

}
