module RefSet where

import qualified Data.Map as Map
import Data.Map (Map)

type Ref a = Integer

newtype RefSet a = RefSet (Map (Ref a) a)

empty :: RefSet a
empty = RefSet Map.empty

insert :: Ord a => a -> RefSet a -> (RefSet a, Ref a)
insert v (RefSet s) =
  (RefSet s', ref)
    where
      s' = Map.insert ref v s
      ref = if Map.null s then 0 else 1 + (fst $ Map.findMax s)

toList (RefSet s) = Map.toList s
