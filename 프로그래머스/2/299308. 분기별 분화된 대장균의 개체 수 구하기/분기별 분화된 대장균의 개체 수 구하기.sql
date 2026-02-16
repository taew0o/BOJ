-- 코드를 작성해주세요
SELECT CONCAT(if(month(DIFFERENTIATION_DATE) in (1,2,3), 1, 
                 if(month(DIFFERENTIATION_DATE) in (4,5,6),2,
                    if(month(DIFFERENTIATION_DATE) in (7,8,9),3,4))), 'Q') QUARTER
                    , COUNT(*) ECOLI_COUNT
FROM ECOLI_DATA
GROUP BY QUARTER
ORDER BY QUARTER;