import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AnalyzedDataComponent } from './analyzed-data.component';

describe('AnalyzedDataComponent', () => {
  let component: AnalyzedDataComponent;
  let fixture: ComponentFixture<AnalyzedDataComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AnalyzedDataComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AnalyzedDataComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
