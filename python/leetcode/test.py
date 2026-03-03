domain = [1,2,3,4]
# variables = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H']
variables = ['F', 'H', 'C', 'D', 'G', 'E', 'A', 'B']
path = [-1]*len(variables) #index means 0->A, 1->B...
solutions = []
failingCount=[0]

def is_valid():
    # A=path[0]
    # B=path[1]
    # C=path[2]
    # D=path[3]
    # E=path[4]
    # F=path[5]
    # G=path[6]
    # H=path[7]
    A=path[6]
    B=path[7]
    C=path[2]
    D=path[3]
    E=path[5]
    F=path[0]
    G=path[4]
    H=path[1]
    #A>G
    if A!=-1 and G!=-1:
        if A<=G: return False
    #A<=H
    if A!=-1 and H!=-1:
        if A>H: return False
    #|F-B|=1
    if B!=-1 and F!=-1:
        if abs(F-B)!=1: return False
    
    # G<H
    if G!=-1 and H!=-1:
        if G>=H: return False
    # |G-C| = 1
    if C!=-1 and G!=-1:
        if abs(G-C)!=1: return False
        
    # |H-C| is even
    if C!=-1 and H!=-1:
        if abs(H-C)%2 != 0: return False
        
    # H != D
    if D!=-1 and H!=-1:
        if H==D: return False
        
    # D ≥ G
    if D!=-1 and G!=-1:
        if D<G: return False
        
    # D != C
    if C!=-1 and D!=-1:
        if D == C: return False
        
    # E != C
    if C!=-1 and E!=-1:
        if E == C: return False
        
    # E < D-1
    if D!=-1 and E!=-1:
        if E >= D-1: return False
        
    # E != H-2
    if E!=-1 and H!=-1:
        if E == H-2: return False
    
    # G != F
    if F!=-1 and G!=-1:
        if G == F: return False
        
    # H != F
    if F!=-1 and H!=-1:
        if H == F: return False
        
    # C != F
    if C!=-1 and F!=-1:
        if C == F: return False
        
    # D != F-1
    if D!=-1 and F!=-1:
        if D == F-1: return False
        
    # |E-F| is odd
    if E!=-1 and F!=-1:
        if abs(E-F)%2 == 0: return False
        
    return True
        
def dfs(level, draw):
    if level == len(variables):
        solutions.append(path.copy())
        print(draw +" solution")
        return
    
    for i in domain:
        path[level] = i
        new=draw + " " +variables[level]+"="+str(i)
        if is_valid():
            dfs(level + 1, new)
        else:
            failingCount[0]+=1
            print(new +" failure")
    path[level] = -1
    
dfs(0,"")
print(solutions)
print(failingCount[0])
  