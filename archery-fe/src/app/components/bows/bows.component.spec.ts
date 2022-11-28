import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BowsComponent } from './bows.component';

describe('BowsComponent', () => {
  let component: BowsComponent;
  let fixture: ComponentFixture<BowsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ BowsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BowsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
