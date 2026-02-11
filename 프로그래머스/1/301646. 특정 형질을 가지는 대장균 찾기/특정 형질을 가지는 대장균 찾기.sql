# -- 코드를 작성해주세요
SELECT COUNT(*) as COUNT
FROM ECOLI_DATA
WHERE GENOTYPE & b'10' = 0 && (GENOTYPE & b'1' >= 1 or GENOTYPE & b'100' >= 1);