import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Warehouses } from "../model/warehouses";
import { WarehouseDetails } from "../model/warehouse-details";
import { WarehouseForm } from "../model/warehouse-form";

@Injectable({
  providedIn: 'root'
})
export class WarehouseService {

  constructor(private http: HttpClient) { }

  getWarehouses(): Observable<Warehouses> {
    return this.http.get<Warehouses>('/api/warehouses');
  }

  getWarehouse(uuid: string): Observable<WarehouseDetails> {
    return this.http.get<WarehouseDetails>('/api/warehouses/' + uuid);
  }

  deleteWarehouse(uuid: string): Observable<any> {
    return this.http.delete('/api/warehouses/' + uuid);
  }

  createWarehouse(warehouseForm: WarehouseForm): Observable<any> {
    return this.http.post('/api/warehouses', warehouseForm);
  }

  updateWarehouse(uuid: string, warehouseForm: WarehouseForm): Observable<any> {
    return this.http.put('/api/warehouses/' + uuid, warehouseForm);
  }
}
