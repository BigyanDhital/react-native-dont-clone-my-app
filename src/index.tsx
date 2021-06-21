import { NativeModules } from 'react-native';

type DontCloneMyAppType = {
  multiply(a: number, b: number): Promise<number>;
};

const { DontCloneMyApp } = NativeModules;

export default DontCloneMyApp as DontCloneMyAppType;
