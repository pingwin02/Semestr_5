import { NgModule } from "@angular/core";
import { RouterModule, Routes } from "@angular/router";
import { WarehouseListComponent } from "./warehouse/view/warehouse-list/warehouse-list.component";
import { WarehouseViewComponent } from "./warehouse/view/warehouse-view/warehouse-view.component";
import { WarehouseEditComponent } from "./warehouse/view/warehouse-edit/warehouse-edit.component";
import { WarehouseCreateComponent } from "./warehouse/view/warehouse-create/warehouse-create.component";
import { ProductViewComponent } from "./product/view/product-view/product-view.component";
import { ProductEditComponent } from "./product/view/product-edit/product-edit.component";
import { ProductCreateComponent } from "./product/view/product-create/product-create.component";


const routes: Routes = [
  {
    component: WarehouseListComponent,
    path: "warehouses",
  },
  {
    component: WarehouseCreateComponent,
    path: "warehouse/create",
  },
  {
    component: WarehouseEditComponent,
    path: "warehouse/:uuid/edit",
  },
  {
    component: WarehouseViewComponent,
    path: "warehouse/:uuid",
  },
  {
    component: ProductCreateComponent,
    path: "warehouse/:uuid/product/create",
  },
  {
    component: ProductViewComponent,
    path: "warehouse/:uuid/product/:id",
  },
  {
    component: ProductEditComponent,
    path: "warehouse/:uuid/product/:id/edit",
  },
  {
    path: "",
    redirectTo: "/warehouses",
    pathMatch: "full",
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
