export interface InformationTableConfig{
  mainProp: string;
  columns: ColumnsConfig[]
}

export interface ColumnsConfig {
  name: string;
  prop: string;
  width?: number;
}