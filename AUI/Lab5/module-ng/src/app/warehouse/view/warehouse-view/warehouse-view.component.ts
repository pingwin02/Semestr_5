import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";
import { WarehouseService } from "../../service/warehouse.service";
import { WarehouseDetails } from "../../model/warehouse-details";

@Component({
  selector: 'app-warehouse-view',
  templateUrl: './warehouse-view.component.html',
  styleUrls: ['./warehouse-view.component.css']
})
export class WarehouseViewComponent implements OnInit {

  constructor(private service: WarehouseService, private route: ActivatedRoute, private router: Router) { }

  warehouse: WarehouseDetails | undefined;

  ngOnInit(): void {
    this.route.params.subscribe((params) => {
      this.service.getWarehouse(params['uuid']).subscribe((warehouse) => {
        this.warehouse = warehouse;
      });
    });
  }

}
