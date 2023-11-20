import { Component, OnInit } from '@angular/core';
import { WarehouseService } from '../../service/warehouse.service';
import { Warehouse } from '../../model/warehouse';
import { Warehouses } from "../../model/warehouses";

@Component({
  selector: 'app-warehouse-list',
  templateUrl: './warehouse-list.component.html',
  styleUrls: ['./warehouse-list.component.css']
})
export class WarehouseListComponent implements OnInit {

  constructor(private service: WarehouseService) { }

  warehouses: Warehouses | undefined;

  ngOnInit(): void {
    this.service.getWarehouses().subscribe(warehouses => this.warehouses = warehouses);
  }

  onDelete(warehouse: Warehouse): void {
    if (confirm("Are you sure to delete " + warehouse.name)) {
      this.service.deleteWarehouse(warehouse.id).subscribe(() => {
        this.ngOnInit();
      });
    }
  }

}
