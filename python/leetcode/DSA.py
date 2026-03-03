def fitness(state):
    A,B,C,D,E,F,G,H = state
    sat = 0

    # 1) A > G
    if A > G: sat += 1

    # 2) A <= H
    if A <= H: sat += 1

    # 3) |F-B| = 1
    if abs(F - B) == 1: sat += 1

    # 4) G < H
    if G < H: sat += 1

    # 5) |G-C| = 1
    if abs(G - C) == 1: sat += 1

    # 6) |H-C| is even
    if abs(H - C) % 2 == 0: sat += 1

    # 7) H != D
    if H != D: sat += 1

    # 8) D >= G
    if D >= G: sat += 1

    # 9) D != C
    if D != C: sat += 1

    # 10) E != C
    if E != C: sat += 1

    # 11) E < D-1
    if E < D - 1: sat += 1

    # 12) E != H-2
    if E != H - 2: sat += 1

    # 13) G != F
    if G != F: sat += 1

    # 14) H != F
    if H != F: sat += 1

    # 15) C != F
    if C != F: sat += 1

    # 16) D != F-1
    if D != F - 1: sat += 1

    # 17) |E-F| is odd
    if abs(E - F) % 2 == 1: sat += 1

    return sat

def compute_fitness_and_probabilities(population):
    """
    population: list of states
    return:
        fitness_list
        probability_list
    """

    fitness_list = []

    # 计算每个 state 的 fitness
    for state in population:
        f = fitness(state)
        fitness_list.append(f)

    total_fitness = sum(fitness_list)

    # 计算 selection probability
    if total_fitness == 0:
        # 如果全为0，均匀分配概率
        probability_list = [1/len(population)] * len(population)
    else:
        probability_list = [
            f / total_fitness for f in fitness_list
        ]

    return fitness_list, probability_list


# GEN0 = [
#     [1,1,1,1,1,1,1,1],
#     [2,2,2,2,2,2,2,2],
#     [3,3,3,3,3,3,3,3],
#     [4,4,4,4,4,4,4,4],
#     [1,2,3,4,1,2,3,4],
#     [4,3,2,1,4,3,2,1],
#     [1,2,1,2,1,2,1,2],
#     [3,4,3,4,3,4,3,4],
# ]

# GEN1=[
# [4,3,2,1,1,2,1,2],
# [1,2,1,2,4,3,2,1],
# [1,2,3,3,1,4,3,4] ,
# [3,4,3,4,3,2,3,4],
# [2,3,2,4,3,4,3,4],
# [3,4,3,2,2,2,2,2],
# [1,1,1,1,4,4,4,4],
# [4,4,4,4,1,3,1,1],
# ]

GEN2=[
[4,3,2,2,2,2,2,2],
[3,4,3,1,1,2,1,2],
[3,4,1,4,1,3,1,1],
[4,4,3,4,3,2,3,4],
[1,2,3,3,2,4,2,2],
[3,4,3,2,1,4,3,4],
[3,4,3,2,2,2,4,4],
[1,1,1,1,4,4,1,2],
]

fitness_list, prob_list = compute_fitness_and_probabilities(GEN2)

for i in range(len(GEN2)):
    print("State:", GEN2[i])
    print("Fitness:", fitness_list[i])
    print("Selection Probability:", round(prob_list[i], 4))
    print()