// function two_sum(nums, target) {
const two_sum = (sums, target) =>{
    let m = new Map();
    for (let i=0; i<nums.length;i++) {
        let diff = target - nums[i];
        if(m.has(diff)) {
            return [m.get(diff), i];
        }
        m.set(nums[i], i);
    }
    return [];
}

let nums = [1,2,3,4];
console.log(two_sum(nums, 5));

let arr=[1,2,3];
let arr2=Array(5);
let arr3=Array.of(1,2,3);

arr.push(4);
arr.pop();
arr.splice(1,2);

// array.splice(开始位置, 删除数量, 要添加的元素1, 要添加的元素2, ...)
arr.splice(1,0,9);

arr.indexOf(3); 
arr.includes(2);
arr.find(x=>x>2);
arr.findIndex(x=>x>2);

arr.forEach((x, i)=>console.log(x,i));

for(let x of arr) console.log(x);

for(let i=0; i<arr.length;i++) console.log(arr[i]);

arr.slice(1,3);
arr.concat([4,5]);


