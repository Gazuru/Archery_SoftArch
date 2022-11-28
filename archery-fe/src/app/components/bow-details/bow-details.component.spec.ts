import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BowDetailsComponent } from './bow-details.component';

describe('BowDetailsComponent', () => {
  let component: BowDetailsComponent;
  let fixture: ComponentFixture<BowDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BowDetailsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BowDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
