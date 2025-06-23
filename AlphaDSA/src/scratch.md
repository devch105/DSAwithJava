# 
  //  some k<n

for(int i=0; i<n; i=i+k){
  for(int j=i+1; j<=k; j++){     ==> O(n)
     // constant work
   }
}

//  some k<n

for(int i=0; i<n; i=i+k){
for(int j=i+1; j<=n; j++){          ==>O(n^2)
// constant work
}
}