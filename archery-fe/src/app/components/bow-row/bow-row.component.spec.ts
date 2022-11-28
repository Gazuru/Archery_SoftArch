import {ComponentFixture, TestBed} from '@angular/core/testing';

import {BowRowComponent} from './bow-row.component';

describe('BowRowComponent', () => {
  let component: BowRowComponent;
  let fixture: ComponentFixture<BowRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BowRowComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(BowRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
