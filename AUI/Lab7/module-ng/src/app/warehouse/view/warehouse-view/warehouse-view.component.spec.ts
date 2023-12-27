import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WarehouseViewComponent } from './warehouse-view.component';

describe('WarehouseViewComponent', () => {
  let component: WarehouseViewComponent;
  let fixture: ComponentFixture<WarehouseViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [WarehouseViewComponent]
    });
    fixture = TestBed.createComponent(WarehouseViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
